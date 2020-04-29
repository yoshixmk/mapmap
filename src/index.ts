export abstract class Key<K> {
  private key: K;
  constructor(key: K) {
    this.key = key;
  }
  get(): K {
    return this.key;
  }
  abstract equals(other: Key<K>): Boolean;
}

export class Value<V> {
  private value: V;
  constructor(value: V) {
    this.value = value;
  }
  get(): V {
    return this.value;
  }
}
export class StringKey extends Key<String> {
  equals(other: Key<String>): Boolean {
    return this.get() === other.get()
  }
}

export class MapMap<K extends StringKey /* union using | */, V> implements Map<K, V> {
  private collections: Map<K, V>;

  readonly size: number;

  constructor() {
    this.collections = new Map<K, V>();
    this.size = 0;
  }

  clear(): void{
    this.collections = new Map<K, V>();
  };
  delete(key: K): boolean {
    return true;
    // return collections.get(key)
  };
  forEach(callbackfn: (value: V, key: K, map: Map<K, V>) => void, thisArg?: any): void {

  };
  get(key: K): V | undefined {
    const entries = this.collections.entries();
    for (const e of entries) {
      if (e[0].equals(key)) {
        return e[1];
      }
    }
  };
  has(key: K): boolean {
    const keys: IterableIterator<K> = this.collections.keys();
    return Array.from(keys).find(k => k.equals(key)) !== undefined;
  };
  set(key: K, value: V): this {
    this.collections.set(key, value);
    return this;
  };
  entries(): IterableIterator<[K, V]> {
    throw new Error("Method not implemented.");
  }
  keys(): IterableIterator<K> {
    throw new Error("Method not implemented.");
  }
  values(): IterableIterator<V> {
    throw new Error("Method not implemented.");
  }
  [Symbol.toStringTag]: string;
  [Symbol.iterator](): IterableIterator<[K, V]> {
    throw new Error("Method not implemented.");
  }
}
