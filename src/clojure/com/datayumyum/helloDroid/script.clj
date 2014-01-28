(ns com.datayumyum.helloDroid.main)

(require 'neko.notify)
(require 'com.rabbitmq.client.ConnectionFactory)
 (def main-layout [:linear-layout {:orientation :vertical}
                   [:edit-text {:hint "Event name3"}]
                   [:button {:text "i'm a button"
                             :on-click (fn [_] (neko.notify/toast "toast to me"))}]])



     (on-ui
     (set-content-view! a
      (make-ui main-layout) ))

(import '(com.rabbitmq.client ConnectionFactory Connection Channel MessageProperties QueueingConsumer))
(defn send [msg]
  (do
    (def factory (ConnectionFactory.))
    (.setHost factory "obi.kaicode.com")
    (def connection (.newConnection factory))
    (def channel (.createChannel connection))
    (def queue "han.printer")
    (.queueDeclare channel queue true false false nil)
    (.basicPublish channel "" queue MessageProperties/PERSISTENT_TEXT_PLAIN (.getBytes msg))    
    (.close channel)
    (.close connection)
    )
)

(defn read []
    (def factory (ConnectionFactory.))
    (.setHost factory "obi.kaicode.com")
    (def connection (.newConnection factory))
    (def channel (.createChannel connection))
    (def queue "han.printer")
    (.queueDeclare channel queue true false false nil)
    (def consumer (QueueingConsumer. channel))
    (.basicConsume channel queue true consumer)
    (def delivery (.nextDelivery consumer))
    (def message (String. (.getBody delivery)))
    (.close channel)
    (.close connection)
    (println message)
    (render (eval (read-string message)))
)

(defn render [ui]
  (on-ui
   (set-content-view! a
                      (make-ui ui) ) )
)
   
