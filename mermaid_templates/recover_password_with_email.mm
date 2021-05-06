graph TD
recover("authenticationWrapper.recoverPassword(..)")
recover --> select("authenticationWrapper.selectForgotPasswordAuthenticator(..)")
select --> verify("authenticationWrapper.verifyAuthenticator(..)")
verify --> hasStatus{"AuthenticationStatus.AWAITING_PASSWORD_RESET"}
hasStatus -- true --> changePassword("authenticationWrapper.changePassword(..)")
hasStatus -- false --> select
