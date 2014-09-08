package info.toyonos.hfr4droid.common.core.utils;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;

public class JsExecutor {
    /**
     * Exécute l'expression javascript sur la webview
     * @param webView webview concernée
     * @param jsExpression expression Javascript à exécuter
     */
    public static void execute(WebView webView, String jsExpression) {
        execute(webView, jsExpression, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                // ignore
            }
        });
    }

    /**
     * Exécute l'expression javascript sur la webview et récupère le retour de l'expression
     * @param webView webview concernée
     * @param jsExpression expression Javascript à exécuter
     */
    public static void execute(WebView webView, String jsExpression, ValueCallback<String> resultCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript(jsExpression, resultCallback);
        }
        else {
            webView.loadUrl("javascript:" + jsExpression);
        }
    }
}
