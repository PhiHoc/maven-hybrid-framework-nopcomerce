package commons;

import lombok.Getter;

import java.io.File;

@Getter
public class GlobalConstants {

    private static GlobalConstants globalConstants;

    private GlobalConstants(){
    }

    public static GlobalConstants getGlobalConstants(){
        if(globalConstants==null){
            globalConstants = new GlobalConstants();
        }
        return globalConstants;
    }
    private final String adminPageUrl = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
    private final String portalPageUrl = "https://demo.nopcommerce.com/";
    private final String logoutPageUrl = portalPageUrl + "/logout";
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String javaVersion = System.getProperty("java.version");
    private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
    private final String browserLog = projectPath + File.separator + "browserLogs";
    private final long longTimeout = 30;
    private final long shortTimeout = 5;
    private final long retryTestFail = 3;
}
