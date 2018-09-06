package android.databinding;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DataBindingUtil {
    private static DataBinderMapper sMapper = new DataBinderMapper();
    private static android.databinding.DataBindingComponent sDefaultComponent = null;

    private DataBindingUtil() {
    }

    public static <T extends ViewDataBinding> T inflate(LayoutInflater inflater, int layoutId, @Nullable ViewGroup parent, boolean attachToParent) {
        return inflate(inflater, layoutId, parent, attachToParent, sDefaultComponent);
    }

    public static <T extends ViewDataBinding> T inflate(LayoutInflater inflater, int layoutId, @Nullable ViewGroup parent, boolean attachToParent, android.databinding.DataBindingComponent bindingComponent) {
        final boolean useChildren = parent != null && attachToParent;
        final int startChildren = useChildren ? parent.getChildCount() : 0;
        final View view = inflater.inflate(layoutId, parent, attachToParent);
        if (useChildren) {
            return bindToAddedViews(bindingComponent, parent, startChildren, layoutId);
        } else {
            return bind(bindingComponent, view, layoutId);
        }
    }

    private static <T extends ViewDataBinding> T bindToAddedViews(android.databinding.DataBindingComponent component, ViewGroup parent, int startChildren, int layoutId) {
        final int endChildren = parent.getChildCount();
        final int childrenAdded = endChildren - startChildren;
        if (childrenAdded == 1) {
            final View childView = parent.getChildAt(endChildren - 1);
            return bind(component, childView, layoutId);
        } else {
            final View[] children = new View[childrenAdded];
            for (int i = 0; i < childrenAdded; i++) {
                children[i] = parent.getChildAt(i + startChildren);
            }
            return bind(component, children, layoutId);
        }
    }

    static <T extends ViewDataBinding> T bind(android.databinding.DataBindingComponent bindingComponent, View root, int layoutId) {
        return (T) sMapper.getDataBinder(bindingComponent, root, layoutId);
    }

    @SuppressWarnings("unchecked")
    static <T extends ViewDataBinding> T bind(android.databinding.DataBindingComponent bindingComponent, View[] roots, int layoutId) {
        return (T) sMapper.getDataBinder(bindingComponent, roots, layoutId);
    }

    @SuppressWarnings("unchecked")
    public static <T extends ViewDataBinding> T bind(View root, android.databinding.DataBindingComponent bindingComponent) {
        T binding = getBinding(root);
        if (binding != null) {
            return binding;
        }
        Object tagObj = root.getTag();
        if (!(tagObj instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        } else {
            String tag = (String) tagObj;
            int layoutId = sMapper.getLayoutId(tag);
            if (layoutId == 0) {
                throw new IllegalArgumentException("View is not a binding layout");
            }
            return (T) sMapper.getDataBinder(bindingComponent, root, layoutId);
        }
    }

    public static <T extends ViewDataBinding> T getBinding(View view) {
        return (T) ViewDataBinding.getBinding(view);
    }

    public static void setDefaultComponent(android.databinding.DataBindingComponent bindingComponent) {
        sDefaultComponent = bindingComponent;
    }

    public static android.databinding.DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }
}