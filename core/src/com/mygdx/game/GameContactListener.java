package com.mygdx.game;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.Array;
/**
 * Created by God on 25.07.2014.
 */
    public class GameContactListener implements ContactListener {

        private int numFootContacts;
        private Array<Body> bodiesToRemove;
        private boolean playerDead;

        public GameContactListener() {
            super();
            bodiesToRemove = new Array<Body>();
        }

        public void beginContact(Contact contact) {

            Fixture fa = contact.getFixtureA();
            Fixture fb = contact.getFixtureB();

            /* что-нибудь делаем при контакте. fixture может выдать body*/

        }

        public void endContact(Contact contact) {
        }

        public boolean playerCanJump() { return numFootContacts > 0; }
        public Array<Body> getBodies() { return bodiesToRemove; }
        public boolean isPlayerDead() { return playerDead; }

        public void preSolve(Contact c, Manifold m) {}
        public void postSolve(Contact c, ContactImpulse ci) {}

    }
