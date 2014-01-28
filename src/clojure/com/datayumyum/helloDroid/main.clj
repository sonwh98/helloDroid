(ns com.datayumyum.helloDroid.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]))

(defactivity com.datayumyum.helloDroid.MyActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! a
      (make-ui [:linear-layout {:orientation :vertical}
                  [:edit-text {:hint "Event name2"}]
                  [:edit-text {:hint "Event location"}]]) )) ))
                



