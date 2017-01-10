<?php

//namespace hello\php;

error_reporting(E_ALL);
require_once'hello/Hello.php';
require_once '/home/fornia/workspace/thrift/lib/php/lib/Thrift/ClassLoader/ThriftClassLoader.php';

use Thrift\ClassLoader\ThriftClassLoader;

$GEN_DIR = realpath(dirname(__FILE__));

$loader = new ThriftClassLoader();
$loader->registerNamespace('Thrift', '/home/fornia/workspace/thrift/lib/php/lib');
$loader->registerDefinition('hello', $GEN_DIR);
$loader->register();


use Thrift\Protocol\TBinaryProtocol;
use Thrift\Transport\TSocket;
use Thrift\Transport\THttpClient;
use Thrift\Transport\TBufferedTransport;
use Thrift\Exception\TException;

try {
    $socket = new TSocket('localhost', 1236);
    $transport = new TBufferedTransport($socket, 1024, 1024);
    $protocol = new TBinaryProtocol($transport);
    $client = new hello\HelloClient($protocol);

    $transport->open();

    $hi = $client->hello('fornia');
    print "return from server".$hi."\n";

    $transport->close();

} catch (TException $tx) {
    print 'TException: ' . $tx->getMessage() . "\n";
}

?>
