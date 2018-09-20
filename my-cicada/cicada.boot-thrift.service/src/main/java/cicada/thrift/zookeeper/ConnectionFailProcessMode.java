package cicada.thrift.zookeeper;

public enum ConnectionFailProcessMode {
    Retry,
    Throw;

    private ConnectionFailProcessMode() {
    }
}
