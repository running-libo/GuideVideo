// Generated code from Butter Knife. Do not modify!
package com.example.guidvideo.guidevideo;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GuidePagerActivity$$ViewBinder<T extends com.example.guidvideo.guidevideo.GuidePagerActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492959, "field 'vpGuide'");
    target.vpGuide = finder.castView(view, 2131492959, "field 'vpGuide'");
    view = finder.findRequiredView(source, 2131492961, "field 'tvEnter'");
    target.tvEnter = finder.castView(view, 2131492961, "field 'tvEnter'");
    view = finder.findRequiredView(source, 2131492960, "field 'llDot'");
    target.llDot = finder.castView(view, 2131492960, "field 'llDot'");
  }

  @Override public void unbind(T target) {
    target.vpGuide = null;
    target.tvEnter = null;
    target.llDot = null;
  }
}
