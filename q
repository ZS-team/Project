[1mdiff --git a/app/src/main/java/com/zsherry/project/CenterImageSpan.java b/app/src/main/java/com/zsherry/project/CenterImageSpan.java[m
[1mindex fc9e36e..ebb43f8 100644[m
[1m--- a/app/src/main/java/com/zsherry/project/CenterImageSpan.java[m
[1m+++ b/app/src/main/java/com/zsherry/project/CenterImageSpan.java[m
[36m@@ -18,6 +18,7 @@[m [mimport java.lang.ref.WeakReference;[m
  * @Description:[m
  */[m
 public class CenterImageSpan extends ImageSpan {[m
[32m+[m[32m    private String str = "abs";[m
 [m
     private WeakReference<Drawable> mDrawableRef;[m
 [m
[1mdiff --git a/app/src/main/java/com/zsherry/project/CstTopBar.java b/app/src/main/java/com/zsherry/project/CstTopBar.java[m
[1mindex 3f29f10..267fa52 100644[m
[1m--- a/app/src/main/java/com/zsherry/project/CstTopBar.java[m
[1m+++ b/app/src/main/java/com/zsherry/project/CstTopBar.java[m
[36m@@ -20,6 +20,7 @@[m [mimport android.widget.TextView;[m
 [m
 public class CstTopBar extends RelativeLayout {[m
 [m
[32m+[m[32m    private String str = "abs";[m
     private LinearLayout layout;[m
     private View view;[m
     private Context context;[m
