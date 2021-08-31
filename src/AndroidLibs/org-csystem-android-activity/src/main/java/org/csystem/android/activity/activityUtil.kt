package org.csystem.android.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import java.io.Serializable


fun <T : Activity> launchActivity(context: Context, cls: Class<T>)
{
    val intent = Intent(context, cls)

    context.startActivity(intent)
}

fun <T : Activity> launchActivity(context: Context, cls: Class<T>, bundle: Bundle)
{
    val intent = Intent(context, cls)

    intent.putExtras(bundle)

    context.startActivity(intent)
}

fun <T : Activity> launchActivity(context: Context, cls: Class<T>, vararg serials: Pair<String, Serializable>)
{
    val intent = Intent(context, cls)

    for ((key, serial) in serials)
        intent.putExtra(key, serial)

    context.startActivity(intent)
}

fun <T : Activity> launchActivityForResult(activity: Activity, cls: Class<T>, requestCode: Int)
{
    val intent = Intent(activity, cls)

    activity.startActivityForResult(intent, requestCode)
}

fun <T : Activity> launchActivityForResult(activity: Activity, cls: Class<T>, requestCode: Int, bundle: Bundle)
{
    val intent = Intent(activity, cls)

    intent.putExtras(bundle)

    activity.startActivityForResult(intent, requestCode)
}