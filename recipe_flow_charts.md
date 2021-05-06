# Basic Login

## Login with Username and Password

![login with username and password](flow_diagrams/login_with_username_and_password.svg)

# Self Service Registration

## Register Name and Email with Password

graph TD
fetch("authenticationWrapper.fetchSignUpFormValues()")
fetch --> register("authenticationWrapper.register(...)")
register --> enroll("authenticationWrapper.enrollAuthenticator(...)")
enroll --> verify("authenticationWrapper.verifyAuthenticator(...)")
verify --> hasTokens{response.tokenResponse != null}
hasTokens -- false --> enroll
hasTokens -- true --> success(response.tokenResponse)

## Register Name and Email with Additional Factors

graph TD
fetch("authenticationWrapper.fetchSignUpFormValues()")
fetch --> register("authenticationWrapper.register(...)")
register --> enroll("authenticationWrapper.enrollAuthenticator(...)")
enroll --> verify("authenticationWrapper.verifyAuthenticator(...)")
verify --> hasTokens{response.tokenResponse != null}
hasTokens -- false --> enroll
hasTokens -- true --> success(response.tokenResponse)

# Password Recovery

## Recover Password with Email
   
graph TD
recover("authenticationWrapper.recoverPassword(..)")
recover --> select("authenticationWrapper.selectForgotPasswordAuthenticator(..)")
select --> verify("authenticationWrapper.verifyAuthenticator(..)")
verify --> hasStatus{"AuthenticationStatus.AWAITING_PASSWORD_RESET"}
hasStatus -- true --> changePassword("authenticationWrapper.changePassword(..)")
hasStatus -- false --> select

# Social Auth

## Login with Social IDP

## Login with SAML/OIDC IDP

# Logout

## Logout of Sample App

graph TD
revoke("authenticationWrapper.revokeToken(..)")
