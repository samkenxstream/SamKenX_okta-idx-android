/*
 * Copyright 2021-Present Okta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.okta.idx.android.network

import com.okta.idx.sdk.api.client.Clients
import com.okta.idx.sdk.api.client.IDXClient
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import java.util.concurrent.atomic.AtomicReference

object Network {
    private val clientConfiguratorReference = AtomicReference<OkHttpConfigurator?>()

    fun okHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.cookieJar(CookieJar.NO_COOKIES)
        builder.retryOnConnectionFailure(false) // handled by SDK
        clientConfiguratorReference.get()?.configure(builder)

        val client = builder.build()
        clientConfiguratorReference.get()?.built(client)
        return client
    }

    fun setConfigurator(configurator: OkHttpConfigurator?) {
        clientConfiguratorReference.set(configurator)
    }

    fun idxClient(): IDXClient {
        return Clients.builder()
            .setIssuer("https://this.does.not.exist.com")
            .setClientId("test-client-id")
            .setScopes(setOf("test-scope-1", "test-scope-2"))
            .setRedirectUri("http://okta.com")
            .build()
    }
}
