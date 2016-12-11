/*
Наприклад: в Java є інтерфейс Map, програміст може не знати як саме він працює і реалізований, але користуватись ним
В бібліотеці Java існує 2 реалізації інтерфейсу Map: класи HashMap i TreeMap.
Програміст і сам може імплементувати інтерфейс Мар у свій клас
*/

//приклад з інтернету
public class MyMap implements Map {

  private ArrayList keys;
  private ArrayList values;

  public MyMap() {
    keys = new ArrayList();
    values = new ArrayList();
  }

  /** Return the number of mappings in this Map. */
  public int size() {
    return keys.size();
  }

  /** Return true if this map is empty. */
  public boolean isEmpty() {
    return size() == 0;
  }

  /** Return true if o is contained as a Key in this Map. */
  public boolean containsKey(Object o) {
    return keys.contains(o);
  }

  /** Return true if o is contained as a Value in this Map. */
  public boolean containsValue(Object o) {
    return keys.contains(o);
  }

  /** Get the object value corresponding to key k. */
  public Object get(Object k) {
    int i = keys.indexOf(k);
    if (i == -1)
      return null;
    return values.get(i);
  }

  /** Put the given pair (k, v) into this map, by maintaining "keys"
   * in sorted order.
   */
  public Object put(Object k, Object v) {
    for (int i=0; i < keys.size(); i++) {
      Object old = keys.get(i);

      /* Does the key already exist? */
      if (((Comparable)k).compareTo(keys.get(i)) == 0) {
        keys.set(i, v);
        return old;
      }

      /* Did we just go past where to put it?
       * i.e., keep keys in sorted order.
       */
      if (((Comparable)k).compareTo(keys.get(i)) == +1) {
        int where = i > 0 ? i -1 : 0;
        keys.add(where, k);
        values.add(where, v);
        return null;
      }
    }

    // Else it goes at the end.
    keys.add(k);
    values.add(v);
    return null;
  }
