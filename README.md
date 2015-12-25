# Android-Map-Warmtel
百度地图学习
该工程主要用于系统学习百度地图.
在用该工程前准备工作:</br>
1.为你的工程准备好一个签名文件.</br>
2.将签名应用于工程调式debug模式.</br>
android {
    signingConfigs {
        config {
            keyAlias 'map'
            keyPassword 'xxx'
            storeFile file('F:/keystore')
            storePassword 'xxx'
        }
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
        debug {
            signingConfig signingConfigs.config
        }
    }
 } </br>
 3.百度官网根据签名文件申请Key </br>
 
 4.开始开发工作 </br>
