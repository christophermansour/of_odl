package com.talentica.sdn.odlofsoftswitch.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OfCapFluxModule extends com.talentica.sdn.odlofsoftswitch.impl.AbstractOfCapFluxModule {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	public OfCapFluxModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public OfCapFluxModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, com.talentica.sdn.odlofsoftswitch.impl.OfCapFluxModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        DataBroker dataBroker = getDataBrokerDependency();
        RpcProviderRegistry rpcProviderRegistry = getRpcRegistryDependency();
        NotificationProviderService notificationProviderService = getNotificationServiceDependency();
        OfCapFlux capFlux = new OfCapFlux(dataBroker, notificationProviderService, rpcProviderRegistry);
        LOG.info("L2Forwarding initialized", capFlux);
        return capFlux;
    }

}