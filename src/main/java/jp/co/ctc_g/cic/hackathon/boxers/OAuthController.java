package jp.co.ctc_g.cic.hackathon.boxers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.box.sdk.BoxItem.Info;

@Controller
@EnableAutoConfiguration
public class OAuthController {

    static final String CLIENT_ID = "nar7tnme7y0sfb72l5bfgznz0bgttu72";
    static final String CLIENT_SECRET = "Ygg7sHOaU3EsDz9kCuDeNka3ZmQqsH5X";
    
    static final String OAUTH_URL = "https://account.box.com/api/oauth2/authorize";

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Box x OAuth example application";
    }

    @RequestMapping("/oauth")
    public String oauth() {
        return "redirect:" + OAUTH_URL +
            "?response_type=code" +
            "&client_id=" + CLIENT_ID +
            "&state=xxxxxxxxx";
    }

    @RequestMapping("/oauth/callback")
    @ResponseBody
    public List<String> oauthCallback(
            @RequestParam("state") String state,
            @RequestParam("code") String code) {
        System.out.printf("state = %s, code = %s", state, code);
        BoxAPIConnection api = new BoxAPIConnection(CLIENT_ID, CLIENT_SECRET, code);
        List<String> names = new ArrayList<>();
        for (BoxItem.Info info : BoxFolder.getRootFolder(api)) {
            names.add(info.getName());
        }
        return names;
    }
}
