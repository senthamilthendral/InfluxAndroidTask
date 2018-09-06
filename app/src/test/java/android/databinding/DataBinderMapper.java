
package android.databinding;

class DataBinderMapper {
    final static int TARGET_MIN_SDK = 21;

    public DataBinderMapper() {
    }

    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch (layoutId) {
            case com.thendral.android.influx.onlineorder.R.layout.layout_food_item: {
                final Object tag = view.getTag();
                if (tag == null) throw new java.lang.RuntimeException("view must have a tag");
                if ("layout-xlarge/layout_food_item_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.LayoutFoodItemBindingXlargeImpl(bindingComponent, view);
                }
                if ("layout/layout_food_item_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.LayoutFoodItemBindingImpl(bindingComponent, view);
                }
                throw new java.lang.IllegalArgumentException("The tag for layout_food_item is invalid. Received: " + tag);
            }
            case com.thendral.android.influx.onlineorder.R.layout.adapter_food_list: {
                final Object tag = view.getTag();
                if (tag == null) throw new java.lang.RuntimeException("view must have a tag");
                if ("layout-xlarge/adapter_food_list_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.AdapterFoodListBindingXlargeImpl(bindingComponent, view);
                }
                if ("layout/adapter_food_list_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.AdapterFoodListBindingImpl(bindingComponent, view);
                }
                throw new java.lang.IllegalArgumentException("The tag for adapter_food_list is invalid. Received: " + tag);
            }
            case com.thendral.android.influx.onlineorder.R.layout.fragment_home: {
                final Object tag = view.getTag();
                if (tag == null) throw new java.lang.RuntimeException("view must have a tag");
                if ("layout/fragment_home_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.FragmentHomeBindingImpl(bindingComponent, view);
                }
                if ("layout-xlarge/fragment_home_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.FragmentHomeBindingXlargeImpl(bindingComponent, view);
                }
                throw new java.lang.IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
            }
            case com.thendral.android.influx.onlineorder.R.layout.activity_base_layout: {
                final Object tag = view.getTag();
                if (tag == null) throw new java.lang.RuntimeException("view must have a tag");
                if ("layout-xlarge/activity_base_layout_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.ActivityBaseLayoutBindingXlargeImpl(bindingComponent, view);
                }
                if ("layout/activity_base_layout_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.ActivityBaseLayoutBindingImpl(bindingComponent, view);
                }
                throw new java.lang.IllegalArgumentException("The tag for activity_base_layout is invalid. Received: " + tag);
            }
            case com.thendral.android.influx.onlineorder.R.layout.layout_cart_item: {
                final Object tag = view.getTag();
                if (tag == null) throw new java.lang.RuntimeException("view must have a tag");
                if ("layout/layout_cart_item_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.LayoutCartItemBindingImpl(bindingComponent, view);
                }
                if ("layout-xlarge/layout_cart_item_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.LayoutCartItemBindingXlargeImpl(bindingComponent, view);
                }
                throw new java.lang.IllegalArgumentException("The tag for layout_cart_item is invalid. Received: " + tag);
            }
            case com.thendral.android.influx.onlineorder.R.layout.layout_sub_item: {
                final Object tag = view.getTag();
                if (tag == null) throw new java.lang.RuntimeException("view must have a tag");
                if ("layout-xlarge/layout_sub_item_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.LayoutSubItemBindingXlargeImpl(bindingComponent, view);
                }
                if ("layout/layout_sub_item_0".equals(tag)) {
                    return new com.thendral.android.influx.onlineorder.databinding.LayoutSubItemBindingImpl(bindingComponent, view);
                }
                throw new java.lang.IllegalArgumentException("The tag for layout_sub_item is invalid. Received: " + tag);
            }
        }
        return null;
    }

    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch (layoutId) {
        }
        return null;
    }

    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch (code) {
            case 738611801: {
                if (tag.equals("layout-xlarge/layout_food_item_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.layout_food_item;
                }
                break;
            }
            case -765974923: {
                if (tag.equals("layout/layout_food_item_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.layout_food_item;
                }
                break;
            }
            case 296937751: {
                if (tag.equals("layout-xlarge/adapter_food_list_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.adapter_food_list;
                }
                break;
            }
            case 899389563: {
                if (tag.equals("layout/adapter_food_list_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.adapter_food_list;
                }
                break;
            }
            case -1115993926: {
                if (tag.equals("layout/fragment_home_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.fragment_home;
                }
                break;
            }
            case 86722390: {
                if (tag.equals("layout-xlarge/fragment_home_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.fragment_home;
                }
                break;
            }
            case -1775191230: {
                if (tag.equals("layout-xlarge/activity_base_layout_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.activity_base_layout;
                }
                break;
            }
            case 1493377374: {
                if (tag.equals("layout/activity_base_layout_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.activity_base_layout;
                }
                break;
            }
            case -226100877: {
                if (tag.equals("layout/layout_cart_item_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.layout_cart_item;
                }
                break;
            }
            case 1278485847: {
                if (tag.equals("layout-xlarge/layout_cart_item_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.layout_cart_item;
                }
                break;
            }
            case 5107983: {
                if (tag.equals("layout-xlarge/layout_sub_item_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.layout_sub_item;
                }
                break;
            }
            case -459069069: {
                if (tag.equals("layout/layout_sub_item_0")) {
                    return com.thendral.android.influx.onlineorder.R.layout.layout_sub_item;
                }
                break;
            }
        }
        return 0;
    }

    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }

    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
                "_all"
                , "appViewModel"};
    }
}