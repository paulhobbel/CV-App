/*
 * Copyright (c) 2018 Paul Hobbel. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 */

package me.paulhobbel.cvapp.utils;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;

import me.paulhobbel.cvapp.models.Contact;

public class ContactUtils {
    /**
     * Simple function to open the default ContractActivity of Android
     * @todo Switch over to ContentProvider to support photo's
     * @param context The context to start the activity on
     * @param contact The contact to add
     */
    public static void addContactActivity(Context context, Contact contact) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        // Add these if we want the user to select whether they want a new/update a contact
//        Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
//        intent.setType(ContactsContract.Contacts.CONTENT_ITEM_TYPE);


        intent.putExtra(ContactsContract.Intents.Insert.NAME, contact.getName());

        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, contact.getEmailAddress());
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);

        intent.putExtra(ContactsContract.Intents.Insert.PHONE, contact.getPhoneNumber());
        intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);

        context.startActivity(intent);
    }
}
