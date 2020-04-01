package vip.efactory.ejpa.example.service.impl;

import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.SystemTenant;
import vip.efactory.ejpa.example.repository.SystemTenantRepository;
import vip.efactory.ejpa.example.service.ISystemTenantService;

@Service
public class SystemTenantServiceImpl extends BaseServiceImpl<SystemTenant, Long, SystemTenantRepository> implements ISystemTenantService {

}
