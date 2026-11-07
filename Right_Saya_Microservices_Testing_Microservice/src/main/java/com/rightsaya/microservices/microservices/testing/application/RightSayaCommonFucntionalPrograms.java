package com.rightsaya.microservices.platform.testing.application;


import com.rightsaya.microservices.platform.testing.application.collections.RightSayaCollections;
import com.rightsaya.microservices.platform.testing.application.concurrency.RightSayaConcurrency;
import com.rightsaya.microservices.platform.testing.application.features.RightSayaJavaEightFeatures;
import com.rightsaya.microservices.platform.testing.application.miscellenous.RightSayaMisellenousCodes;
import com.rightsaya.microservices.platform.testing.application.streams.RightSayaStreams;

public class RightSayaCommonFucntionalPrograms {

    private static final RightSayaCommonFucntionalPrograms whiteHeavenCommonFucntionalPrograms = RightSayaCommonFucntionalPrograms.getInstance();

    private static RightSayaCommonFucntionalPrograms _instance;

    private static RightSayaCollections whiteHeavenCollections;

    private static RightSayaConcurrency whiteHeavenConcurrency;

    private static RightSayaJavaEightFeatures whiteHeavenJavaEightFeatures;

    private static RightSayaStreams whiteHeavenStreams;

    private static RightSayaMisellenousCodes whiteHeavenMisellenousCodes;

    public static RightSayaCommonFucntionalPrograms getInstance() {
        if(_instance == null) {
            _instance = new RightSayaCommonFucntionalPrograms();
        }
        if(_instance.getRightSayaCollections() == null) {
            whiteHeavenCollections = new RightSayaCollections();
        }
        if(_instance.getRightSayaConcurrency() == null) {
            whiteHeavenConcurrency = new RightSayaConcurrency();
        }
        if(_instance.getRightSayaJavaEightFeatures() == null) {
            whiteHeavenJavaEightFeatures = new RightSayaJavaEightFeatures();
        }
        if(_instance.getRightSayaStreams() == null) {
            whiteHeavenStreams = new RightSayaStreams();
        }
        if(_instance.getRightSayaMisellenousCodes() == null) {
            whiteHeavenMisellenousCodes = new RightSayaMisellenousCodes();
        }
        return _instance;
    }

    public static RightSayaMisellenousCodes getRightSayaMisellenousCodes() {
        return whiteHeavenMisellenousCodes;
    }

    public RightSayaCollections getRightSayaCollections() {
        return whiteHeavenCollections;
    }


    public RightSayaConcurrency getRightSayaConcurrency() {
        return whiteHeavenConcurrency;
    }

    public RightSayaJavaEightFeatures getRightSayaJavaEightFeatures() {
        return whiteHeavenJavaEightFeatures;
    }

    public RightSayaStreams getRightSayaStreams() {
        return whiteHeavenStreams;
    }

    private static void executeCodes() {
        RightSayaCollections whiteHeavenCollections = whiteHeavenCommonFucntionalPrograms.getRightSayaCollections();
        RightSayaConcurrency whiteHeavenConcurrency = whiteHeavenCommonFucntionalPrograms.getRightSayaConcurrency();
        RightSayaJavaEightFeatures whiteHeavenJavaEightFeatures = whiteHeavenCommonFucntionalPrograms.getRightSayaJavaEightFeatures();
        RightSayaStreams whiteHeavenStreams = whiteHeavenCommonFucntionalPrograms.getRightSayaStreams();;
        RightSayaMisellenousCodes whiteHeavenMisellenousCodes = whiteHeavenCommonFucntionalPrograms.getRightSayaMisellenousCodes();
        // Streams
        whiteHeavenStreams.runExecuteJavaCodes();
        // Collections
        whiteHeavenCollections.runExecuteJavaCodes();
        //Data Structure
        whiteHeavenMisellenousCodes.runExecuteJavaCodes();
    }



}
