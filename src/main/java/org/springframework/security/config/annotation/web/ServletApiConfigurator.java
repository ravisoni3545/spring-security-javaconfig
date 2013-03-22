/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.config.annotation.web;

import org.springframework.security.config.annotation.AbstractSecurityConfigurator;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

/**
 * @author Rob Winch
 *
 */
public class ServletApiConfigurator extends AbstractSecurityConfigurator<DefaultSecurityFilterChain,DefaultSecurityFilterChainBuilder> {
    private SecurityContextHolderAwareRequestFilter securityContextRequestFilter = new SecurityContextHolderAwareRequestFilter();

    public ServletApiConfigurator rolePrefix(String rolePrefix) {
        securityContextRequestFilter.setRolePrefix(rolePrefix);
        return this;
    }

    protected void doConfigure(DefaultSecurityFilterChainBuilder builder)
            throws Exception {
        securityContextRequestFilter.afterPropertiesSet();
        builder.addFilter(securityContextRequestFilter);
    }
}