package com.hcl.management.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="portfolioservice")
public interface PortfolioConnect {

}
