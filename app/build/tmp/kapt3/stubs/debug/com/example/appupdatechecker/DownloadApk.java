package com.example.appupdatechecker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/example/appupdatechecker/DownloadApk;", "Landroidx/appcompat/app/AppCompatActivity;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "startDownloadingApk", "", "url", "", "fileName", "DownloadNewVersion", "app_debug"})
public final class DownloadApk extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    
    public DownloadApk(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void startDownloadingApk(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void startDownloadingApk(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\tJ%\u0010\u0011\u001a\u00020\u00042\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0013\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0017\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0019H\u0014J%\u0010\u001d\u001a\u00020\u00192\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0013\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0002H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/example/appupdatechecker/DownloadApk$DownloadNewVersion;", "Landroid/os/AsyncTask;", "", "", "", "context", "Landroid/content/Context;", "downloadUrl", "fileName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "bar", "Landroid/app/ProgressDialog;", "getContext", "()Landroid/content/Context;", "getDownloadUrl", "()Ljava/lang/String;", "getFileName", "doInBackground", "p0", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "getUriFromFile", "Landroid/net/Uri;", "filePath", "onPostExecute", "", "result", "(Ljava/lang/Boolean;)V", "onPreExecute", "onProgressUpdate", "values", "([Ljava/lang/Integer;)V", "openNewVersion", "location", "app_debug"})
    static final class DownloadNewVersion extends android.os.AsyncTask<java.lang.String, java.lang.Integer, java.lang.Boolean> {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String downloadUrl = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String fileName = null;
        private android.app.ProgressDialog bar;
        
        public DownloadNewVersion(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String downloadUrl, @org.jetbrains.annotations.NotNull()
        java.lang.String fileName) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDownloadUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFileName() {
            return null;
        }
        
        @java.lang.Override()
        protected void onPreExecute() {
        }
        
        @java.lang.Override()
        protected void onProgressUpdate(@org.jetbrains.annotations.NotNull()
        java.lang.Integer... values) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.String... p0) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean result) {
        }
        
        private final void openNewVersion(java.lang.String location) {
        }
        
        private final android.net.Uri getUriFromFile(java.lang.String filePath) {
            return null;
        }
    }
}