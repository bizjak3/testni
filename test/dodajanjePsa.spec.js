describe('Dodajanje novega psa', function () {
    it('Obisk strani za dodajanje in dodajenje', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('metkanovak')
            .should('have.value', 'metkanovak')

        cy.get('.password')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)

        cy.get('.btn').contains(' Dodaj novega psa ')
            .click()

        cy.get('h1').contains('Dodaj psa')

        cy.get('input[name="ime"]')
            .type('Car')
            .should('have.value', 'Car')

        cy.get('input[name="pasma"]')
            .type('carska')
            .should('have.value', 'carska')

        cy.get('textarea[name="komentarji"]')
            .type('Udomačena psica')
            .should('have.value', 'Udomačena psica')

        cy.get('.btn')
            .contains('Dodaj štirinožca')
            .click()
    });
});
