import StringKey from './StringKey';

export default class MapMap<K extends StringKey /* union using | */, V> implements Map<K, V> {
  private collections: Map<K, V>;

  public readonly size: number;

  public [Symbol.toStringTag]: string = 'Map that supports object literals';
  public constructor() {
    this.collections = new Map<K, V>();
    this.size = 0;
  }

  public clear(): void{
    this.collections = new Map<K, V>();
  }
  public delete(key: K): boolean {
    const keys: IterableIterator<K> = this.keys();
    const targetKey: K | undefined = Array.from(keys).find((k: K) => k.equals(key));
    if (targetKey !== undefined) {
      return this.collections.delete(targetKey);
    }
    return false;
  }
  /* eslint @typescript-eslint/no-explicit-any: ["error", { "fixToUnknown": true }]*/
  public forEach(callbackfn: (value: V, key: K, map: Map<K, V>) => void, thisArg?: unknown): void {
    this.collections.forEach(callbackfn, thisArg);
  }
  public get(key: K): V | undefined {
    const entries: IterableIterator<[K, V]> = this.entries();
    for (const e of entries) {
      if (e[0].equals(key)) {
        return e[1];
      }
    }
  }
  public has(key: K): boolean {
    const keys: IterableIterator<K> = this.keys();
    return Array.from(keys).find((k: K) => k.equals(key)) !== undefined;
  }
  public set(key: K, value: V): this {
    this.collections.set(key, value);
    return this;
  }
  public entries(): IterableIterator<[K, V]> {
    return this.collections.entries();
  }
  public keys(): IterableIterator<K> {
    return this.collections.keys();
  }
  public values(): IterableIterator<V> {
    return this.collections.values();
  }
  public [Symbol.iterator](): IterableIterator<[K, V]> {
    return this.collections[Symbol.iterator]();
  }
}
