InfluxAndroidTask

Test Application designed for online ordering for food menu. App enables the user to add the menu Item to the cart, and Pay option is provided for payment.

Implementation
Application renders the UI from reading JSON from the local instead of getting over it from Network. App is designed with MVVM design pattern. But in some cases, maintaining the ViewModel gives boilerplate, hence directly used the binding objects.

Tabs
Based on tab item count, dynamically tabs will be added to the tab layout. Also integrated with view pager for sliding. Application will get the response initially, and based on tab type it will render in the same RecyclerView but with respective FoodList.

BottomSheet
BottomSheet used to show the updated prize amount of the total menus that added. Dynamically it will update the sum of items through listener. On Expanding the BottomSheet, it will list out the menus that added so far in the cart along with the price and no.of items on each menu.

Add/Remove Menu
Each Food Item has the UI for adding and removing the item. While making action on each button, cart will be updated automatically.

Known Issues
Back and Skip button actions were not provided.
Pay option action is disabled.
Veg/Non Veg Icon not placed on top of food item.
Place holder Image and other arrow images are not matched with the given UI.
Since the given response giving error in "Large" object of sub Item one, maintained response in asset json.
