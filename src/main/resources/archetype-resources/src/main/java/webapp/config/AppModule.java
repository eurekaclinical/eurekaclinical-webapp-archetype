#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webapp.config;

/*-
 * ${symbol_pound}%L
 * ${artifactId}
 * %%
 * Copyright (C) 2016 Emory University
 * %%
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
 * ${symbol_pound}L%
 */

import ${package}.webapp.client.ExternalClient;
import ${package}.webapp.client.InternalServiceClient;
import ${package}.webapp.client.ServiceClientRouterTable;
import ${package}.webapp.props.WebappProperties;
import com.google.inject.AbstractModule;
import ${package}.common.comm.clients.RouterTable;
import ${package}.standardapis.props.CasEurekaClinicalProperties;
import ${package}.standardapis.props.EurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class AppModule extends AbstractModule{
	private final WebappProperties properties;
	private final InternalServiceClient serviceClient;
	private final ExternalClient externalWebappClient;

	public AppModule(WebappProperties inProperties) {
		this.properties = inProperties;
		this.serviceClient = new InternalServiceClient(this.properties.getServiceUrl());
		this.externalWebappClient = new ExternalClient(this.properties.getUrl());
	}

	@Override
	protected void configure() {
		bind(RouterTable.class).to(ServiceClientRouterTable.class);
		bind(CasEurekaClinicalProperties.class).toInstance(this.properties);
		bind(InternalServiceClient.class).toInstance(this.serviceClient);
		bind(ExternalClient.class).toInstance(this.externalWebappClient);

	}
}
