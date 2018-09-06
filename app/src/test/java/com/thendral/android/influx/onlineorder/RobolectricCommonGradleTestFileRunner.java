// "(c) Walgreen Co. All rights reserved"

package com.thendral.android.influx.onlineorder;


import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.FileFsFile;
import org.robolectric.util.Logger;
import org.robolectric.util.ReflectionHelpers;

public class RobolectricCommonGradleTestFileRunner extends RobolectricTestRunner {
    private static final String BUILD_OUTPUT = "src/test";
    private static final String BUILD_OUTPUT_Res = "build/intermediates";

    public RobolectricCommonGradleTestFileRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {

        if (config.constants() == Void.class) {
            Logger.error("Field 'constants' not specified in @Config annotation");
            Logger.error("This is required when using RobolectricGradleTestRunner!");

        }

        final String type = getType(config);
        final String flavor = getFlavor(config);
        final String packageName = getPackageName(config);

        FileFsFile res;
        final FileFsFile assets;
        FileFsFile manifest = null;

        // res/merged added in Android Gradle plugin 1.3-beta1
        if (FileFsFile.from(BUILD_OUTPUT_Res, "res", "merged").exists()) {
            res = FileFsFile.from(BUILD_OUTPUT_Res, "res", "merged", flavor, type);
        } else if (FileFsFile.from(BUILD_OUTPUT_Res, "res").exists()) {
            res = FileFsFile.from(BUILD_OUTPUT_Res, "res", flavor, type);
        } else {
            res = FileFsFile.from(BUILD_OUTPUT_Res, "bundles", flavor, type, "res");
        }



        if (FileFsFile.from(BUILD_OUTPUT, "assets").exists()) {
            assets = FileFsFile.from(BUILD_OUTPUT, "assets", flavor);
        } else {
            assets = FileFsFile.from(BUILD_OUTPUT, "", flavor, "assets");
        }

        if (FileFsFile.from(BUILD_OUTPUT, "manifests").exists()) {
            manifest = FileFsFile.from(BUILD_OUTPUT, "manifests", "full", flavor, type, "AndroidManifest.xml");
        } else {
            manifest = FileFsFile.from(BUILD_OUTPUT, "bundles", flavor, type, "AndroidManifest.xml");
        }

        manifest = FileFsFile.from(config.manifest());

        Logger.debug("Robolectric assets directory: " + assets.getPath());
        Logger.debug("   Robolectric res directory: " + res.getPath());
        Logger.debug("   Robolectric manifest path: " + manifest.getPath());
        Logger.debug("    Robolectric package name: " + packageName);
        return new AndroidManifest(manifest, res, assets, packageName);

    }

    private static String getType(Config config) {
        return ReflectionHelpers.getStaticField(config.constants(), "BUILD_TYPE");
    }

    private static String getFlavor(Config config) {
        return ReflectionHelpers.getStaticField(config.constants(), "FLAVOR");
    }

    private static String getPackageName(Config config) {
        final String packageName = config.packageName();
        if (packageName != null && !packageName.isEmpty()) {
            return packageName;
        } else {
            return ReflectionHelpers.getStaticField(config.constants(), "APPLICATION_ID");
        }
    }
}
