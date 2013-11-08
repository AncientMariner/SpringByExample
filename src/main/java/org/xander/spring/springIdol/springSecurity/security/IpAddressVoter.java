package org.xander.spring.springIdol.springSecurity.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.Collection;

/**
 *
 Note that this voter will only process the access attributes that start with the IP_ prefix. At the
 moment, it only supports the IP_LOCAL_HOST access attribute. If the user is a web client whose IP address
 is equal to 127.0.0.1 or 0:0:0:0:0:0:0:1—the last value being returned by networkless Linux
 workstations—this voter will vote to grant access. Otherwise, it will vote to deny access. If the resource
 does not have an access attribute starting with IP_, it will abstain from voting.
 */
public class IpAddressVoter extends RoleVoter {
    public static final String IP_PREFIX = "IP_";
    public static final String IP_LOCAL_HOST = "IP_LOCAL_HOST";

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute.getAttribute() != null && attribute.getAttribute().startsWith(IP_PREFIX);
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> configList) {
        if (!(authentication.getDetails() instanceof WebAuthenticationDetails)) {
            return ACCESS_DENIED;
        }
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        String address = details.getRemoteAddress();
        int result = ACCESS_ABSTAIN;
        for (ConfigAttribute config : configList) {
            result = ACCESS_DENIED;
            if (IP_LOCAL_HOST.equals(config.getAttribute())) {
                if (address.equals("127.0.0.1") || address.equals("0:0:0:0:0:0:0:1")) {
                    return ACCESS_GRANTED;
                }
            }
        }
        return result;
    }

}
