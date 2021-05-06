graph TD
fetch("authenticationWrapper.fetchSignUpFormValues()")
fetch --> register("authenticationWrapper.register(...)")
register --> enroll("authenticationWrapper.enrollAuthenticator(...)")
enroll --> verify("authenticationWrapper.verifyAuthenticator(...)")
verify --> hasTokens{response.tokenResponse != null}
hasTokens -- false --> enroll
hasTokens -- true --> success(response.tokenResponse)
