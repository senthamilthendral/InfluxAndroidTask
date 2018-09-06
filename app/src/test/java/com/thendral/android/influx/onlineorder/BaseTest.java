// "(c) Walgreen Co. All rights reserved"

package com.thendral.android.influx.onlineorder;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

@RunWith(RobolectricCommonBindingGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/test/AndroidManifest.xml")
public class BaseTest {


    @Before
    public void setup() {
    }

}
