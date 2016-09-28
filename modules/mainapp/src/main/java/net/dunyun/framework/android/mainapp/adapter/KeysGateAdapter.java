package net.dunyun.framework.android.mainapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psoft.framework.android.base.adapter.AngmaBaseAdapter;
import com.psoft.framework.android.base.utils.SharedUtil;

import net.dunyun.framework.android.mainapp.util.BluetoothUtil;
import net.dunyun.framework.android.mainapp.vo.KeyVo;
import net.dunyun.framework.android.mainapp.vo.LockVo;
import net.dunyun.framework.android.mainapp.vo.gate.KeyChainVo;
import net.dunyun.framework.lock.R;

/**
 *
 * @author chenzp
 * @date 2015/11/19
 */
public class KeysGateAdapter extends AngmaBaseAdapter<KeyChainVo> {
    String phone;
    Context mContext;
	public KeysGateAdapter(Context mContext) {
		super(mContext);
        this.mContext = mContext;
        phone = SharedUtil.getString(mContext, "phone");
	}

	public View getView(final int position, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		KeyChainVo keyChainVo = list.get(position);
        phone = SharedUtil.getString(mContext, "phone");
			viewHolder = new ViewHolder();
			view = inflater.inflate(R.layout.item_key, null);
			viewHolder.ItemImage = (ImageView) view.findViewById(R.id.ItemImage);
			viewHolder.name = (TextView) view.findViewById(R.id.name);
			view.setTag(viewHolder);
        if(position == (list.size() - 1)){
            viewHolder.ItemImage.setBackgroundResource(R.drawable.add_key);
            viewHolder.ItemImage.setImageDrawable(null);
            viewHolder.name.setText("申请钥匙");
        }else{
			viewHolder.ItemImage.setBackgroundResource(R.drawable.item_gate_bg);
			viewHolder.ItemImage.setImageDrawable(null);
            viewHolder.name.setText(keyChainVo.getChainName());
        }

		return view;
	}

	final static class ViewHolder {
		ImageView ItemImage;
		TextView name;
	}
}