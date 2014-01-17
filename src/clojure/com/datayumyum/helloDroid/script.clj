(ns com.datayumyum.helloDroid.main)

(def main-layout [:linear-layout {:orientation :vertical}
                  [:edit-text {:hint "Event name3"}]])


    (on-ui
     (set-content-view! a
      (make-ui main-layout) ))


