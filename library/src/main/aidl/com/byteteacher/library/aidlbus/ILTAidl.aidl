// ILTAidl.aidl
package com.byteteacher.library.aidlbus;

import com.byteteacher.library.aidlbus.ILTAidlCallback;

// Declare any non-default types here with import statements

interface ILTAidl {

    String post(String data, in ILTAidlCallback callback);
}
