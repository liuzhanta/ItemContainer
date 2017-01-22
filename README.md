# ItemContainer
A custom item container to simplify the single section view.

Getting started
---------------
Add the ItemContainer dependency to your build.gradle.
    
    dependencies {
       compile 'com.zterry.itemcontainer:library:1.0.1'
    }

Screen Shot
-----------
![](https://github.com/liuzhanta/ItemContainer/blob/master/Screenshot.png)

Usage Xml
---------



- []**Common Attrs**

| Attrs               | value                         |
| --------            | -----:                        |
| ItemLocationType    | single,top,middle,bottom,none |
| hasLine             | true,false                    |
| lineMarginDirection | top,bottom                    |

- []**SingleItemContainer Attrs**

| Attrs               | value                         |
| --------            | -----:                        |
| title               | string                        |
| titleTextColor      | color                         |
| titleTextSize       | dimension                     |
| titleDrawableLeft   | reference                     |
| noArrow             | true or false                 |
| contentLayout       | reference                     |

And you can use ItemContainer like following this:
      
    <com.zterry.itemcontainer.SingleItemContainer
            android:layout_width="match_parent"
            android:layout_height="@dimen/single_item_container_height"
            android:layout_marginTop="16dp"
            app:noArrow="true"
            app:ItemLocationType="single"
            app:title="SingleItemContainer-Single"
            app:titleDrawableLeft="@drawable/ic_change_history_red_300_24dp"
            app:titleTextColor="@color/gray_800" />
For more usage ,you can see the ![ItemContainerDemo](https://github.com/liuzhanta/ItemContainer/tree/master/ItemContainer-Demo)
         
            


Developed by
------------
Name: ZTerry Liu  
E-mail: tata1989y@gmail.com  
Subject: ItemContainer  