// BbotMdmModule.java

package menu.bbot;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.ComponentName;
import java.util.List;


public class BbotMdmModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public BbotMdmModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "BbotMdm";
    }

    @ReactMethod
    public void isManaged(final Promise promise){
         DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getReactApplicationContext().getSystemService(
            Context.DEVICE_POLICY_SERVICE);

        List<ComponentName> admins = devicePolicyManager.getActiveAdmins();
         if (admins == null) {
            promise.resolve(false);
            return;
        }
        for (ComponentName admin : admins) {
            String adminPackageName = admin.getPackageName();
            if (devicePolicyManager.isDeviceOwnerApp(adminPackageName)
                || devicePolicyManager.isProfileOwnerApp(adminPackageName)) {
                promise.resolve(adminPackageName);
                return;
            }
        }
        promise.resolve(false);
    }

    /** Requires API Level 31 (Android 12)
    @ReactMethod
    public void getEnrollmentSpecificId(final Promise promise){
         DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getReactApplicationContext().getSystemService(
            Context.DEVICE_POLICY_SERVICE);

        String enrollmentSpecificId = devicePolicyManager.getEnrollmentSpecificId();
        promise.resolve(enrollmentSpecificId);
    }
    */



}
