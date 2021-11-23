// barcaffe.js created with Cypress
//
// Start writing your Cypress tests below!
// If you're unfamiliar with how Cypress works,
// check out the link below and learn how to write your first test:
// https://on.cypress.io/writing-first-test
describe('Dodajanje novega psa', function () {

    const COOKIE_NAME = "gdpr_level_1_necessary";
// The value meaning that user has accepted the cookie policy
const COOKIE_VALUE = "1";

Cypress.on("window:before:load", window => {
  window.document.cookie = `${COOKIE_NAME}=${COOKIE_VALUE}`;
});

    it('Obisk strani za dodajanje in dodajenje', function () {
        cy.visit('https://www.barcaffe.si/play/start')



        cy.get('input[name="email"]')
            .type('bizjak3@gmail.com')
            .should('have.value', 'bizjak3@gmail.com')

        cy.get('input[name="password"]')
            .type('9XLD9Sc88inMnXd')
            .should('have.value', '9XLD9Sc88inMnXd')

        cy.get('input[name="log_in"]')
            .click()
        cy.wait(500)

        

        cy.get('.sh-button--primary').contains('IGRAJ')
        .click()

        cy.wait(1000)

        cy.get('.sh-button--primary').contains('DODAJ KAVO')
            .click()

        cy.wait(7000)
            
        cy.get('.sh-button--primary').contains('DODAJ VRELO VODO')
            .click()

        cy.wait(1000)

        cy.get('.sh-button--primary').contains('PREMEŠAJ')
            .click()

        cy.wait(1000)

        cy.get('.sh-button--primary').contains('PREMEŠAJ PREMEŠAJ')
            .click()

        cy.wait(500)

        cy.get('.sh-button--primary').contains('PREMEŠAJ PREMEŠAJ')
            .click()

        cy.wait(8000)

       
        

        

    });
});
