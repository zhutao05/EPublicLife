package com.cimcitech.epubliclife.activity.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.adapter.home.HomeAdapter;
import com.cimcitech.epubliclife.adapter.home.HomeGridAViewAdapter;
import com.cimcitech.epubliclife.model.NewsVo;
import com.cimcitech.epubliclife.widget.MyGridView;
import com.cimcitech.epubliclife.widget.StickyScrollView;
import com.cimcitech.epubliclife.widget.Utility;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends Fragment implements StickyScrollView.OnScrollChangedListener {

    @Bind(R.id.home_grid)
    MyGridView homeGrid;
    @Bind(R.id.tabMainContainer)
    FrameLayout tabMainContainer;
    @Bind(R.id.content_layout)
    LinearLayout contentLayout;
    @Bind(R.id.scrollView)
    StickyScrollView scrollView;
    @Bind(R.id.titleBar_layout)
    RelativeLayout titleBarLayout;
    @Bind(R.id.listContent)
    ListView listContent;

    private HomeAdapter adapter;
    private List<NewsVo> newsVos;
    private Handler uiHandler = null;
    private final int INIT_VIEW = 1001;
    private int height;
    private View view;
    private HomeGridAViewAdapter gridAViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        ButterKnife.bind(this, view);
        initHandler();
        initView();
        initListeners();
        return view;
    }

    /**
     * 初始化View
     */
    private void initView() {
        /******list数据*****/
        newsVos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            NewsVo news = new NewsVo();
            news.setTitle(i + "hello word");
            newsVos.add(news);
        }
        adapter = new HomeAdapter(getActivity(), newsVos);
        uiHandler.sendEmptyMessage(INIT_VIEW);
        /*****************/

        scrollView.setOnScrollListener(this);
        StatusBarUtil.setTranslucentForImageView(getActivity(), 0, homeGrid);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) titleBarLayout.getLayoutParams();
        params.setMargins(0, getStatusHeight(), 0, 0);
        titleBarLayout.setLayoutParams(params);
        gridAViewAdapter = new HomeGridAViewAdapter(getActivity());
        homeGrid.setAdapter(gridAViewAdapter);
        homeGrid.setSelector(R.drawable.hide_listview_yellow_selector);
        homeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                }

            }
        });
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    private int getStatusHeight() {
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resourceId);

    }


    private void initListeners() {
        //获取内容总高度
        final ViewTreeObserver vto = contentLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                height = contentLayout.getHeight();
                //注意要移除
                contentLayout.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);

            }
        });

        //获取Fragment高度
        ViewTreeObserver viewTreeObserver = tabMainContainer.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                height = height - tabMainContainer.getHeight();
                //注意要移除
                tabMainContainer.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);
            }
        });

        //获取title高度
        ViewTreeObserver viewTreeObserver1 = titleBarLayout.getViewTreeObserver();
        viewTreeObserver1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                height = height - titleBarLayout.getHeight() - getStatusHeight();//计算滑动的总距离
                scrollView.setStickTop(titleBarLayout.getHeight() + getStatusHeight());//设置距离多少悬浮
                //注意要移除
                titleBarLayout.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (t <= 0) {
            titleBarLayout.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
            StatusBarUtil.setTranslucentForImageView(getActivity(), 0, homeGrid);
        } else if (t > 0 && t <= height) {
            float scale = (float) t / height;
            int alpha = (int) (255 * scale);
            titleBarLayout.setBackgroundColor(Color.argb((int) alpha, 30, 144, 255));//设置标题栏的透明度及颜色
            StatusBarUtil.setTranslucentForImageView(getActivity(), alpha, homeGrid);//设置状态栏的透明度
        } else {
            titleBarLayout.setBackgroundColor(Color.parseColor("#0e90ff"));
            StatusBarUtil.setTranslucentForImageView(getActivity(), 255, homeGrid);
        }
    }

    private void initHandler() {
        uiHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case INIT_VIEW:
                        listContent.setAdapter(adapter);
                        new Utility().setListViewHeightBasedOnChildren(listContent);
                        break;
                }
            }
        };
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
