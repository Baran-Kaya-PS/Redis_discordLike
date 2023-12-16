package org.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisManager {

    private Jedis jedis; // Client Redis

    public RedisManager(String host, int port) {
        // Constructeur pour initialiser la connexion Redis
        jedis = new Jedis(host, port);
    }

    public void publish(String channel, String message) {
        // Méthode pour publier un message sur un canal
        jedis.publish(channel, message);
    }

    public void subscribe(JedisPubSub jedisPubSub, String channel) {
        // Méthode pour s'abonner à un canal
        // À utiliser dans un thread séparé car c'est un appel bloquant
        new Thread(new Runnable() { // on utilise un thread pour ne pas bloquer l'interface graphique, pour effectuer plusieurs opérations en même temps
            @Override
            public void run() {
                jedis.subscribe(jedisPubSub, channel);
            }
        }).start();
    }

    public void closeConnection() {
        // Méthode pour fermer la connexion Redis
        if (jedis != null) {
            jedis.close();
        }
    }
    public static void main(String[] args) {
        RedisManager redisManager = new RedisManager("localhost", 6379);
        redisManager.publish("test", "Hello World!");
        redisManager.closeConnection();
    }
}
