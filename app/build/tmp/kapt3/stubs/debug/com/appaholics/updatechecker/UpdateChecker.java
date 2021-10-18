package com.appaholics.updatechecker;

import java.lang.System;

/**
 * @author Raghav Sood
 * @version API 2
 * @since API 1
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010!\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/appaholics/updatechecker/UpdateChecker;", "", "mContext", "Landroid/content/Context;", "toasts", "", "(Landroid/content/Context;Z)V", "TAG", "", "downloadManager", "Lcom/appaholics/updatechecker/DownloadManager;", "haveValidContext", "isOnline", "()Z", "<set-?>", "isUpdateAvailable", "useToasts", "versionCode", "", "getVersionCode", "()I", "checkForUpdateByVersionCode", "", "url", "download", "apkUrl", "downloadAndInstall", "hasGooglePlayInstalled", "install", "launchMarketDetails", "makeToastFromString", "Landroid/widget/Toast;", "text", "readFile", "app_debug"})
public final class UpdateChecker {
    private final android.content.Context mContext = null;
    private final java.lang.String TAG = "UpdateChecker";
    
    /**
     * Should be called after checkForUpdateByVersionCode()
     * @return Returns true if an update is available, false if not.
     * @since API 1
     */
    private boolean isUpdateAvailable = false;
    private boolean haveValidContext = false;
    private boolean useToasts = false;
    private com.appaholics.updatechecker.DownloadManager downloadManager;
    
    @kotlin.jvm.JvmOverloads()
    public UpdateChecker(@org.jetbrains.annotations.Nullable()
    android.content.Context mContext) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UpdateChecker(@org.jetbrains.annotations.Nullable()
    android.content.Context mContext, boolean toasts) {
        super();
    }
    
    public final boolean isUpdateAvailable() {
        return false;
    }
    
    /**
     * Checks for app update by version code.
     *
     * Example call:
     * updateChecker.checkForUpdateByVersionCode("http://www.example.com/version.txt");
     *
     * @param url URL at which the text file containing your latest version code is located.
     * @since API 1
     */
    public final void checkForUpdateByVersionCode(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public final int getVersionCode() {
        return 0;
    }
    
    /**
     * Downloads and installs the update apk from the URL
     *
     * @param apkUrl URL at which the update is located
     * @since API 1
     */
    public final void downloadAndInstall(@org.jetbrains.annotations.Nullable()
    java.lang.String apkUrl) {
    }
    
    /**
     * Must be called only after download().
     * @since API 2
     * @throws NullPointerException Thrown when download() hasn't been called.
     */
    public final void install() {
    }
    
    /**
     * Downloads the update apk, but does not install it
     *
     * @param apkUrl URL at which the update is located.
     * @since API 2
     */
    public final void download(@org.jetbrains.annotations.Nullable()
    java.lang.String apkUrl) {
    }
    
    public final boolean isOnline() {
        return false;
    }
    
    /**
     * Launches your app's page on Google Play if it exists.
     *
     * @since API 2
     */
    public final void launchMarketDetails() {
    }
    
    /**
     * Checks to use if the user's device has Google Play installed
     * @return true if Google Play is installed, otherwise false
     * @since API 2
     */
    public final boolean hasGooglePlayInstalled() {
        return false;
    }
    
    /**
     * Makes a toast message with a short duration from the given text.
     * @param text The text to be displayed by the toast
     * @return The toast object.
     * @since API 2
     */
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"ShowToast"})
    public final android.widget.Toast makeToastFromString(@org.jetbrains.annotations.Nullable()
    java.lang.String text) {
        return null;
    }
    
    /**
     * Reads a file at the given URL
     *
     * @param url The URL at which the file is located
     * @return Returns the content of the file if successful
     * @since API 1
     */
    private final java.lang.String readFile(java.lang.String url) {
        return null;
    }
}