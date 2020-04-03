package vip.efactory.ejpa.example.service.impl;

import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.SysTenant;
import vip.efactory.ejpa.example.repository.SysTenantRepository;
import vip.efactory.ejpa.example.service.ISysTenantService;

@Service
public class SysTenantServiceImpl extends BaseServiceImpl<SysTenant, Long, SysTenantRepository> implements ISysTenantService {

}
