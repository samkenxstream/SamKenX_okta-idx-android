graph TD
authenticate("val response = idxAuthenticationWrapper.authenticate(AuthenticationOptions(#quot;username#quot;, #quot;password#quot;))")
authenticate --> success("response.tokenResponse")
