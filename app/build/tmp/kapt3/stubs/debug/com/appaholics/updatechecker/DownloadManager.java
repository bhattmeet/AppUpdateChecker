package com.appaholics.updatechecker;

import java.lang.System;

/**
 * DO NOT USE ON YOUR OWN. All calls are handled through UpdateChecker.
 *
 * @author Raghav Sood
 * @version API 2
 * @since API 1
 */
@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.CUPCAKE)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0011\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0017\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0014J%\u0010\u0019\u001a\u00020\u00142\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0011\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\t\u001a\u00020\u0002X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/appaholics/updatechecker/DownloadManager;", "Landroid/os/AsyncTask;", "", "", "", "mContext", "Landroid/content/Context;", "installAfterDownload", "(Landroid/content/Context;Z)V", "TAG", "downloaded", "isOnline", "()Z", "progressDialog", "Landroid/app/ProgressDialog;", "doInBackground", "sUrl", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "install", "", "onPostExecute", "result", "(Ljava/lang/Boolean;)V", "onPreExecute", "onProgressUpdate", "values", "([Ljava/lang/Integer;)V", "app_debug"})
public class DownloadManager extends android.os.AsyncTask<java.lang.String, java.lang.Integer, java.lang.Boolean> {
    private final android.content.Context mContext = null;
    private android.app.ProgressDialog progressDialog;
    private final java.lang.String TAG = "UpdateDownloadManager";
    private boolean installAfterDownload = true;
    private boolean downloaded = false;
    
    @kotlin.jvm.JvmOverloads()
    public DownloadManager(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadManager(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, boolean installAfterDownload) {
        super();
    }
    
    private final boolean isOnline() {
        return false;
    }
    
    /**
     * Sets up the progress dialog to notify user of download progress
     *
     * @since API 1
     */
    @java.lang.Override()
    protected void onPreExecute() {
    }
    
    /**
     * Updates our progress bar with the download information
     *
     * @since API 1
     */
    @java.lang.Override()
    protected void onProgressUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.Integer... values) {
    }
    
    /**
     * Downloads the update file in a background task
     *
     * @since API 1
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull()
    java.lang.String... sUrl) {
        return null;
    }
    
    /**
     * Dismissed progress dialog, calls install() if installAfterDownload is true
     *
     * @since API 1
     */
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean result) {
    }
    
    /**
     * Launches an Intent to install the apk update.
     *
     * @since API 2
     */
    public final void install() {
    }
}