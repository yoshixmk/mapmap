export class MapMap<K, V> implements Map<K, V> {
  private collections = new Map<K, V>();

  readonly size: number;

  constructor() {
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
  get(key: K): V {
    throw new Error("Method not implemented.");
  };
  has(key: K): boolean {
    const keys: IterableIterator<K> = this.collections.keys();
    return Array.from(keys).includes(key);
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
