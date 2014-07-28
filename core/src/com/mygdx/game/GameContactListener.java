package com.mygdx.game;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.objects.Coin;
import com.mygdx.game.screens.GameScreen;

import java.util.Iterator;

/**
 * Created by God on 25.07.2014.
 */
    public class GameContactListener implements ContactListener {

        private int numFootContacts;
        private Array<Body> bodiesToRemove;
        private boolean playerDead;
        private World world;

        public GameContactListener(World world) {
            super();
            this.world = world;
            bodiesToRemove = new Array<Body>();
        }

        public void beginContact(Contact contact) {

            Fixture fa = contact.getFixtureA();
            Fixture fb = contact.getFixtureB();
            //System.out.println("contact");



        }

        public void endContact(Contact contact) {

            //System.out.println("not contact");


        }

         public void preSolve(Contact contact, Manifold m) {


         }

         public void postSolve(Contact contact, ContactImpulse impulse) {

             Fixture fa = contact.getFixtureA();
             Fixture fb = contact.getFixtureB();
             Body body = null;

             if (fa.getBody().getUserData().equals("player") && fb.getBody().getUserData().equals("coin") ) {
                 body = fb.getBody();
             }

             if (fa.getBody().getUserData().equals("coin") && fb.getBody().getUserData().equals("player") ) {
                 body = fa.getBody();
             }

             if(body != null) {
                 body.setActive(false);
                 world.destroyBody(body);
             }


         }


        public boolean playerCanJump() { return numFootContacts > 0; }
        public Array<Body> getBodies() { return bodiesToRemove; }
        public boolean isPlayerDead() { return playerDead; }


    }
