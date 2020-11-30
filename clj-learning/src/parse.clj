(require '[instaparse.core :as insta])
;; You need to require instaparse.core as insta, see Quickstart in
;; the Instaparse documentation (https://github.com/Engelberg/instaparse#quickstart)

;; EDIFACT file format

(def parser (insta/parser
              "message = segment+
               segment = tag element+ terminator newline?
               tag = #'[A-Z0-9]{3}'
               element = elem-delim elem-component
               <elem-component> = simple | composite

               <composite> = simple (component-delim simple)*
               <simple> = chars

               chars = (escaped-char | char)*
               escaped-char = #'\\?.'
               <char> = #'[^+:\\'\\?]+'

               <elem-delim> = <'+'>
               <component-delim> = <':'>
               <newline> = <'\\r'?> <'\\n'>
               <terminator> = <\"'\">"))

(defn run-parser
  [s]
  (->> s
       parser
       (insta/transform
         {:chars str
          :escaped-char second})))

(def str1 "UNB+UNOC:3+SE1212121212:ZZZ+DE3434343434:ZZZ+150728:0000+1234567'
UNH+1+ORDERS:D:96A:UN'
BGM+220+100'
DTM+4:20150701:102'
NAD+BY+++Buyer company+Street name+City'
LIN+1++Article #4232:SA'
QTY+47:40'
UNS+S'
CNT+2:1'
UNT+9+1'
UNZ+1+1234567'")

(run-parser str1)

(def as-and-bs
  (insta/parser
    "S = AB*
     AB = A B
     A = 'a'+
     B = 'b'+"))

(as-and-bs "aaaaabbbaaaabb")

(def as-and-bs-auto-whitespace
  (insta/parser
    "S = AB*
     AB = A B
     A = 'a'+
     B = 'b'+"
    :auto-whitespace :standard))

(as-and-bs "aaaaa bbb aaaa  bb")
(as-and-bs-auto-whitespace "aaaaa bbb aaaa  bb")

