package com.google.android.settings.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

import com.android.settings.accounts.AccountFeatureProvider;
import com.android.settings.R;
import com.android.settings.overlay.FeatureFactory;

public class AccountFeatureProviderGoogleImpl implements AccountFeatureProvider {
    @Override
    public String getAccountType() {
        return FeatureFactory.getAppContext().getString(R.string.account_type);
    }

    @Override
    public Account[] getAccounts(Context context) {
        return AccountManager.get(context).getAccountsByType(getAccountType());
    }
}
