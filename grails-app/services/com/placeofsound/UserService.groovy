package com.placeofsound

import grails.transaction.Transactional

@Transactional
class UserService {
    static final String ADMIN_ROLE = "admin"
    static final String BUYER_ROLE = "buyer"
    static final String USER_COOKIE = "user_cookie"

    long createNewUser(String name, String lastName, String email, String password, String role, String userName) {
        User userInstance = new User()

        userInstance.name = name
        userInstance.lastName = lastName
        userInstance.email = email
        userInstance.password = password
        userInstance.role = role
        userInstance.userName = userName ?: buildDefaultUser(name, lastName)
        userInstance.cookie = getRandomNumber()

        userInstance.save(failOnError: true, flush: true)

        return userInstance.cookie
    }

    long logUserIn(String userName, String password) {
        long result = 0
        User user = User.findByUserName(userName)

        if (user && user.password == password) result = updateCookie(user)

        return result
    }

    void logUserOut(long cookie) {
        User user = User.findByCookie(cookie)

        if (user) {
            user.cookie = 0
            user.save(failOnError: true, flush: true)
        }
    }

    boolean isAdminUser(long cookieValue) {
        return ADMIN_ROLE == User.findByCookie(cookieValue)?.role
    }

    private long updateCookie(User user) {
        long newCookieValue = getRandomNumber()
        user.cookie = newCookieValue
        user.save(failOnError: true, flush: true)
        return newCookieValue
    }

    private String buildDefaultUser(String name, String lastName) {
        return "${name}.${lastName}"
    }

    private long getRandomNumber() {
        return ((Math.random() * 10000) + 1000) as long
    }

}
