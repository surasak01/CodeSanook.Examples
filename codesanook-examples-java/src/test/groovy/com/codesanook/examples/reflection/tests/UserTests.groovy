package com.codesanook.examples.reflection.tests

import com.codesanook.examples.reflection.User
import spock.lang.Specification
import java.lang.reflect.*;

class UserTests extends Specification {
    def "getFullName should return correct full name"() {
        given:
            def user =new User()
            user.setFirstName("AA")
            user.setLastName("BB")
        when:
            def result = user.getFullName()
        then:
            result == "AA BB"
    }

    def "getDeclaredMethods with Reflection should return 5 method"() {
        given:
            def user = new User()
        when:
            Class userClass = user.getClass();
            Method[] methods = userClass.getDeclaredMethods();
        then:
            methods.length == 5
    }

    def "invoke getFullName method with Reflection should return correct full name"() {
        given:
            def user = new User()
            user.setFirstName("AA")
            user.setLastName("BB")
        when:
            Class userClass = user.getClass()
            Method method = userClass.getMethod("getFullName")
            def fullName = method.invoke(user, null)
        then:
            fullName == "AA BB"
    }
}
