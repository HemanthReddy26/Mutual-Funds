package com.hcl.management.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="userservice")
public interface UserConnect {

}
